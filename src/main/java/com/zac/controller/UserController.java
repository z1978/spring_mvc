package com.zac.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zac.business.form.UserForm;
import com.zac.business.model.User;
import com.zac.business.service.UserService;

/**
 * このアノテーションをつけて、component-scanさせるとControllerとして扱われます。
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * formモデルのバインダーの初期化。リクエストパラメタをモデルに変換するたびに呼ばれる。
	 */
	@InitBinder("form")
	public void initBinderForm(WebDataBinder binder) {
		// バインドするときの日付のフォーマット指定。
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "user.upDate",
				new CustomDateEditor(dateFormat, true));

		// Userオブジェクトのうち、user.nameパラメタを受け取りたくない場合
		binder.setAllowedFields("user.age", "user.upDate");
	}

	/**
	 * モデルオブジェクトの初期化
	 */
	@ModelAttribute("form")
	public UserForm newRequest(
			@RequestParam(required = false, value = "user.id") String userId) {
		UserForm f = new UserForm();
		//
		User user = null;
		if (userId == null) {
			user = new User();
		} else {
			user = this.userService.getUser(userId);
		}
		//
		f.setUser(user);
		return f;
	}

	// リクエスト処理------------------------------------------
	@RequestMapping(value = "edit/input", method = RequestMethod.GET)
	public String input(UserForm form) {
		// 既にnewRequestでモデルをDBから取り出し、設定しているので何もする必要がない
		return "user-Edit-Input";
	}

	@RequestMapping(value = "edit/confirm", method = RequestMethod.POST)
	public String confirm(@Valid UserForm form, BindingResult result) {
		// @Validを指定したモデルは妥当性チェックが実行される。
		if (result.hasErrors()) {
			return "user-Edit-Input";
		}
		return "user-Edit-Confirm";
	}

	@RequestMapping(value = "edit/finish", method = RequestMethod.POST)
	public String finish(@Valid UserForm form, BindingResult result)
			throws Exception {
		if (result.hasErrors()) {
			return "user-Edit-Input";
		}

		// データ更新
		this.userService.updateUser(form.user);
		return "user-Edit-Finish";
	}

	/**
	 * テストデータの配列を返却する。
	 */
	@RequestMapping(value = "edit/getTestData1", method = RequestMethod.GET)
	@ResponseBody
	public String getTestData() {

		String datas = "test data 1";

		return datas;
	}

	@RequestMapping(value = "edit/getTestData2", method = RequestMethod.POST)
	@ResponseBody
	public String getTestData2(@RequestBody String json) throws IOException,
			ServletException {
		System.err.println(json);
		String[] datas = { "test1", "test2", "test3" };

		return json;
	}

	@Autowired
	private Outcome outcome;

	@RequestMapping(value = "edit/jsonList", method = RequestMethod.GET)
	@ResponseBody
	public Outcome getResult(@RequestBody Attender attender) {
		outcome.setResult(attender.getAugend() + attender.getAddend());
		return outcome;
	}

	// @RequestMapping(value="/jsonList", method=RequestMethod.GET)
	// @ResponseBody
	// public List<Person> jsonList() {
	// return findPersonList();
	// }
	// @ResponseBody
	// @RequestMapping("/list")
	// public List<String> list(ModelMap modelMap) {
	// String hql = "select c from Clothing c ";
	// Page<Clothing> page = new Page<Clothing>();
	// page.setPageSize(6);
	// page = clothingServiceImpl.queryForPageByHql(page, hql);
	//
	// return page.getResult();
	// }

}
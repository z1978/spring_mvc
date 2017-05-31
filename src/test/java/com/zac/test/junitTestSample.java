package com.zac.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.zac.test.common.ZacTestConfiguration;

import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * junit test sample
 * 
 * @author zac
 * @version 1.0 Jan 27, 2014 4:17:02 PM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = {ZacTestConfiguration.class,} )
public class junitTestSample {
	private static final Logger log = LoggerFactory
			.getLogger(junitTestSample.class);
	
	private String className = this.getClass().getName();
	
	@ClassRule
	public static WireMockClassRule wireMockRule;
	
	// test DB
	private static EmbeddedDatabase testDataBase;
	private static ScriptRunner scriptRunner;

	
	@SuppressWarnings("unused")
	private static Pattern dbBean2StrPattern;
	
	@Autowired
	public static TestData testDatas;

	
	@Rule
	public WireMockClassRule instanceRule = wireMockRule;
	
	

	@BeforeClass
	public static void execBeforeClass() throws SQLException {
		log.debug("*** START ***");
		testDataBase = new EmbeddedDatabaseBuilder()
		.setType(EmbeddedDatabaseType.HSQL).continueOnError(true)
		.addScript("classpath:SQLs/zac_db_schema.sql")
		.ignoreFailedDrops(true).build();
		
		
		wireMockRule = new WireMockClassRule(18088);
		scriptRunner = new ScriptRunner(testDataBase.getConnection());

//
//		scriptRunner = new ScriptRunner(testDataBase.getConnection());
//
//		dbBean2StrPattern = Pattern.compile("^\\S+@\\w+\\[(.+)\\]$",
//				Pattern.CASE_INSENSITIVE);

		log.debug("*** END ***");
	}

	@SuppressWarnings("static-access")
	@Before
	public void execBefore() throws Exception {
		log.debug("*** START ***");
		
	
		testDatas.cleanTables(scriptRunner);

		log.debug("*** END ***");
	}

	@Test
	public void testMain() {
		try {
			prepareData("SQLs/test01.sql");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String[] strs = new String[2];
		strs[0] = "hoge";
		strs[1] = "piyo";

		String s = strs[0].substring(1);
		System.out.println(s);

		String[] strs2 = { "hoge", "piyo" };
		for (String str : strs2) {
			System.out.println(str);
		}
		for (int i = 0; i < strs2.length; i++) {
			String str = strs[i];
			System.out.println(str);
		}
		for (String str : "hoge,piyo".split(",")) {
			System.out.println(str);
		}

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("りんご", "apple");
		map.put("ぶどう", "grapes");
		for (Map.Entry<String, String> e : map.entrySet()) {
			String key = e.getKey();
			String data = e.getValue();

			System.out.printf("%s: %s%n", key, data);
		}

		if (map.containsKey("りんご")) {
			System.out.print("りんごを英語にすると");
			System.out.println(map.get("りんご"));
		} else {
			System.out.println("指定したキーは存在しません");
		}

		List<String> listString = new ArrayList<String>(5);
		listString.add("hoge");
		listString.add("piyo");
		listString.add("foo");
		listString.add("bar");
		int cnt = listString.size();
		int index = 1;
		for (String str : listString) {
			StringBuilder stringBuilder = new StringBuilder();
			if (index > 2) {
				stringBuilder.append(index);
				stringBuilder.append("/");
				stringBuilder.append(cnt);
				stringBuilder.append(" is ");
				stringBuilder.append(str);
				System.out.println(stringBuilder);
			}

			index++;
		}
		// exportCsv();
		// importCsv();
	}

	/**
	 * CSV エクスポート
	 * 
	 * @throws Exception
	 */
	public void exportCsv() {
		System.err.println("CSVエクスポートした");
	}

	/**
	 * CSVインポート
	 * 
	 * @throws Exception
	 */
	public void importCsv() {
		System.err.println("CSVインポートした");

	}
	
	
	private static void prepareData(String classPathUrl) throws IOException{
		scriptRunner.runScript(new InputStreamReader(new ClassPathResource(classPathUrl).getInputStream()));
	}

}
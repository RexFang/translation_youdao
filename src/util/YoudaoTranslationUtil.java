package util;

import java.util.HashMap;
import java.util.Map;

public class YoudaoTranslationUtil {
	//接口请求地址
	public static final String REQUEST_URL = "http://fanyi.youdao.com/openapi.do";
	
	//应用代码(申请时填写)
	public static final String YOUDAO_KEYFROM = "SpeakOut";
	
	//key值(申请后有道给出的key)
	public static final String YOUDAO_KEY = "2070040004";
		
	//返回结果的类型，固定为data
	public static final String YOUDAO_TYPE = "data";
	
	//返回结果的数据格式:xml
	public static final String YOUDAO_DOCTYPE_XML = "xml";
	
	//返回结果的数据格式:json
	public static final String YOUDAO_DOCTYPE_JSON = "json";
	
	//返回结果的数据格式:jsonp
	public static final String YOUDAO_DOCTYPE_JSONP = "jsonp";
	
	//版本，当前最新版本为1.1
	public static final String YOUDAO_VERSION = "1.1";
	
	//可选参数，表示只获取词典数据
	public static final String YOUDAO_ONLY_DICT = "dict";
	
	//可选参数，只获取翻译数据
	public static final String YOUDAO_ONLY_TRANSLATE = "translate";
	
	//错误码
	public static final Map<String, String> YOUDAO_ERROR_CODE = new HashMap<String, String>(); 
	
	static{
		YOUDAO_ERROR_CODE.put("0", "正常");
		YOUDAO_ERROR_CODE.put("20", "要翻译的文本过长");
		YOUDAO_ERROR_CODE.put("30", "无法进行有效的翻译");
		YOUDAO_ERROR_CODE.put("40", "不支持的语言类型");
		YOUDAO_ERROR_CODE.put("50", "无效的key");
		YOUDAO_ERROR_CODE.put("60", "无词典结果，仅在获取词典结果生效");
	}
	
}

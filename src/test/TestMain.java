package test;

import java.io.IOException;
import java.net.URLEncoder;

import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;

import util.HttpUtil;
import util.YoudaoTranslationUtil;

public class TestMain {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		String text = "我想真的用心工作的人，用创业的心去工作的人，不会有太多的抱怨，各位同事，咱们忍一忍收一收，每天真的有那么多值得抱怨，那么多值得吐槽的嘛？每天一上班手机就震个不停，吐槽个不停，下了班还是……想想您进入蔚来之前是否做好加入一个初创公司的决心，不看好蔚来，你为何又选择蔚来。公司给大家带来的各种福利，为什么没有看到大家多好的地方更多的点赞，对不足之处的更多的包容，却是引来如此多的吐槽。哪一天公司这些福利，全都消失了，大家会不会就没有什么值得吐槽的了？";
		StringBuffer requestUrl = new StringBuffer(YoudaoTranslationUtil.REQUEST_URL);
		requestUrl.append("?keyfrom=");
		requestUrl.append(YoudaoTranslationUtil.YOUDAO_KEYFROM);
		requestUrl.append("&key=");
		requestUrl.append(YoudaoTranslationUtil.YOUDAO_KEY);
		requestUrl.append("&type=");
		requestUrl.append(YoudaoTranslationUtil.YOUDAO_TYPE);
		requestUrl.append("&doctype=");
		requestUrl.append(YoudaoTranslationUtil.YOUDAO_DOCTYPE_JSON);
		requestUrl.append("&version=");
		requestUrl.append(YoudaoTranslationUtil.YOUDAO_VERSION);
		requestUrl.append("&q=");
		requestUrl.append(URLEncoder.encode(text, "utf-8"));
		
		JSONObject json = HttpUtil.doHttpGet(requestUrl.toString());
		System.out.println(json.toString());
	}
}

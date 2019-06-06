package com.sdk.wx.cp.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sdk.wx.cp.api.MediaApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.api.impl.MediaApiImpl;
import com.sdk.wx.cp.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 素材管理接口单元测试
 * @author yangtao
 * @date 2019/06/03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MediaApiImplTest {

	/**
	 * 公共执行器
	 */
	@Autowired
	private WechatCommonApi wechatCommonApi;

	/**
	 * 要测试的第三方应用suiteId
	 */
	String suiteId = "ww5b5fc5fcf496fade";
	
	/**
	 * 测试token数据
	 */
	@Autowired
	private TestUtil testUtil;
	
	//上传临时素材
	public void upload() throws WxErrorException, IOException{
		MediaApi mediaApi = new MediaApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(mediaApi.upload(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), WxConsts.MediaFileType.FILE, new File("E:\\temp\\batch_party_sample.csv"))));
		//【请求地址】: https://qyapi.weixin.qq.com/cgi-bin/media/upload?type=file&access_token=9H7RQ3jmx3E0Y6BEfXwM1h5nPgkBIEG4m2e-Nme8McapUY06Pg6GE5LOsY0vcVP21kBvtt73qZs3jiMldzsSKgUsHrXtZBy6-bfW_OoYTZ9S8ljyGdAxJnighVWdE1pvvkTyHviZYVaarsWIEWPLOM8ARXOVPEqCMoZzZYxNzHXOFKC4nWY_Dp6jzy6cXNWQjpI96Bkrh7e36pr1DcEqNg
		//【响应数据】：{"type":"image","mediaId":"3kumlQtDs1vfLmYdz1ioy5WURLgmjE7uphSdhoM_xei61yRw_xjlzz7xk6BMulMt5","createdAt":1559551111}
		//【响应数据】：{"type":"image","mediaId":"317sL9bBWwO2nVTew8Y-XRjB9mnmd7SbCo-OHtMl2GyI","createdAt":1559555437}
		//【响应数据】：{"type":"file","mediaId":"3nwSqQpoLUEBs9SLz-V_1FogtQ6ka5MPW1uBcosvTfDitwuwQ1dy2dMum6SKvikC2","createdAt":1559556260}
		//amr格式文件【响应数据】：{"type":"voice","mediaId":"3nGkhBAB3uTqax9IET0wPxDT_5qqpEfFjLO341yjy3ew4gkVBpDT12KOVqMkFP6Ye","createdAt":1559614459}
		//addCUser 【响应数据】：{"type":"file","mediaId":"3xrSU0DjQYXllscYMiHeUv3yvyxm9e3Lu1q8NmytXg1I","createdAt":1559619971}
		//replaceparty【响应数据】：{"type":"file","mediaId":"3EyjHUEZMbuQ43jdh6IbYX2EqaKXBGCvsai9DUJqVDiM","createdAt":1559620856}
	}
	
	//上传永久图片
	public void uploadImg() throws WxErrorException{
		MediaApi mediaApi = new MediaApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(mediaApi.uploadImg(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), new File("E:\\1111.png"))));
		//【请求地址】: https://qyapi.weixin.qq.com/cgi-bin/media/uploadimg?access_token=9H7RQ3jmx3E0Y6BEfXwM1h5nPgkBIEG4m2e-Nme8McapUY06Pg6GE5LOsY0vcVP21kBvtt73qZs3jiMldzsSKgUsHrXtZBy6-bfW_OoYTZ9S8ljyGdAxJnighVWdE1pvvkTyHviZYVaarsWIEWPLOM8ARXOVPEqCMoZzZYxNzHXOFKC4nWY_Dp6jzy6cXNWQjpI96Bkrh7e36pr1DcEqNg
		//【请求参数】：E:\1111.png
		//【响应数据】：{"url":"http://p.qpic.cn/pic_wework/68696431/fbfdc2eba49cde7138df22e9c10946e4e126ac2776fc408e/0","createdAt":0}
	}
	
	//获取临时素材
	@Test
	public void download() throws WxErrorException, IOException{
		MediaApi mediaApi = new MediaApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		FileInputStream fis = new FileInputStream(mediaApi.download(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), 
				"3psB3C7iFocuY85MFdH8uytLMzzR6Dqq36mxir3dAddU",
				new File(wechatCommonApi.getConfigStorage().getMediaTempPath())));
		log.info("fileLength:{}",fis.available());
		fis.close();
		//【请求地址】: https://qyapi.weixin.qq.com/cgi-bin/media/get?media_id=3psB3C7iFocuY85MFdH8uytLMzzR6Dqq36mxir3dAddU&access_token=9H7RQ3jmx3E0Y6BEfXwM1h5nPgkBIEG4m2e-Nme8McapUY06Pg6GE5LOsY0vcVP21kBvtt73qZs3jiMldzsSKgUsHrXtZBy6-bfW_OoYTZ9S8ljyGdAxJnighVWdE1pvvkTyHviZYVaarsWIEWPLOM8ARXOVPEqCMoZzZYxNzHXOFKC4nWY_Dp6jzy6cXNWQjpI96Bkrh7e36pr1DcEqNg
		//【请求参数】：null
		//【响应数据】：E:\temp\batch_party_sample304869630835113673.csv
	}
	
	//获取高清语音素材
	//TODO 需要js-sdk支持
	public void getJssdkFile() throws WxErrorException{
		MediaApi mediaApi = new MediaApiImpl(wechatCommonApi);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		File file = new File("E:\\temp");
		mediaApi.getJssdkFile(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), "3kumlQtDs1vfLmYdz1ioy5WURLgmjE7uphSdhoM_xei61yRw_xjlzz7xk6BMulMt5", file);
	}
	
}

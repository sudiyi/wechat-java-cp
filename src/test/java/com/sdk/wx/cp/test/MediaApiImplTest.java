package com.sdk.wx.cp.test;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sdk.wx.cp.api.MediaApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.api.impl.MediaApiImpl;
import com.sdk.wx.cp.storage.InMemoryConfigStorage;
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

	@Autowired
	private WechatCommonApi wechatCommonApi;

	@Autowired
	private InMemoryConfigStorage inMemoryConfigStorage;
	
	private String suiteId;
	
	/**
	 * 测试token数据
	 */
	@Autowired
	private TestUtil testUtil;
	
	//上传临时素材
	@Test
	public void upload() throws WxErrorException, IOException{
		MediaApi mediaApi = new MediaApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(mediaApi.upload(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), WxConsts.MediaFileType.FILE, new File("E:\\temp\\batch_party_sample.csv"))));
		//【响应数据】：{"type":"image","mediaId":"3kumlQtDs1vfLmYdz1ioy5WURLgmjE7uphSdhoM_xei61yRw_xjlzz7xk6BMulMt5","createdAt":1559551111}
		//【响应数据】：{"type":"image","mediaId":"317sL9bBWwO2nVTew8Y-XRjB9mnmd7SbCo-OHtMl2GyI","createdAt":1559555437}
		//上传file类型数据时，遇到了文件太小，的情况（文件实际大小5kb,接口要求说明的大于5字节就行，但实际情况不行）
		//【响应数据】：{"type":"file","mediaId":"3nwSqQpoLUEBs9SLz-V_1FogtQ6ka5MPW1uBcosvTfDitwuwQ1dy2dMum6SKvikC2","createdAt":1559556260}
		//amr格式文件【响应数据】：{"type":"voice","mediaId":"3nGkhBAB3uTqax9IET0wPxDT_5qqpEfFjLO341yjy3ew4gkVBpDT12KOVqMkFP6Ye","createdAt":1559614459}
		//addCUser 【响应数据】：{"type":"file","mediaId":"3xrSU0DjQYXllscYMiHeUv3yvyxm9e3Lu1q8NmytXg1I","createdAt":1559619971}
		//replaceparty【响应数据】：{"type":"file","mediaId":"3EyjHUEZMbuQ43jdh6IbYX2EqaKXBGCvsai9DUJqVDiM","createdAt":1559620856}
	}
	
	//上传永久图片
	public void uploadImg() throws WxErrorException{
		MediaApi mediaApi = new MediaApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		log.info(GsonUtil.create().toJson(mediaApi.uploadImg(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), new File("E:\\1111.png"))));
		//【响应数据】：{"url":"http://p.qpic.cn/pic_wework/68696431/fbfdc2eba49cde7138df22e9c10946e4e126ac2776fc408e/0","createdAt":0}
	}
	
	//获取临时素材
	//TODO 文件没下载下来
	public void download() throws WxErrorException, IOException{
		MediaApi mediaApi = new MediaApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		File file = new File("E:\\temp");
		mediaApi.download(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), 
				"3kumlQtDs1vfLmYdz1ioy5WURLgmjE7uphSdhoM_xei61yRw_xjlzz7xk6BMulMt5",
				file);
	}
	
	//获取高清语音素材
	//TODO 需要js-sdk支持
	public void getJssdkFile() throws WxErrorException{
		MediaApi mediaApi = new MediaApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		File file = new File("E:\\temp");
		mediaApi.getJssdkFile(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), "3kumlQtDs1vfLmYdz1ioy5WURLgmjE7uphSdhoM_xei61yRw_xjlzz7xk6BMulMt5", file);
	}
	
}

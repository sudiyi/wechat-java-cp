package com.sdk.wx.cp.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sdk.wx.cp.api.SendMessageApi;
import com.sdk.wx.cp.api.WechatCommonApi;
import com.sdk.wx.cp.api.impl.SendMessageApiImpl;
import com.sdk.wx.cp.bean.MessageSend;
import com.sdk.wx.cp.bean.UpdateTaskCardSend;
import com.sdk.wx.cp.bean.MessageSend.MessageArticles;
import com.sdk.wx.cp.bean.MessageSend.MessageBtn;
import com.sdk.wx.cp.bean.MessageSend.MessageFile;
import com.sdk.wx.cp.bean.MessageSend.MessageImage;
import com.sdk.wx.cp.bean.MessageSend.MessageMPArticles;
import com.sdk.wx.cp.bean.MessageSend.MessageMPNews;
import com.sdk.wx.cp.bean.MessageSend.MessageMarkdown;
import com.sdk.wx.cp.bean.MessageSend.MessageMiniprogramNotice;
import com.sdk.wx.cp.bean.MessageSend.MessageNews;
import com.sdk.wx.cp.bean.MessageSend.MessageTaskCard;
import com.sdk.wx.cp.bean.MessageSend.MessageText;
import com.sdk.wx.cp.bean.MessageSend.MessageTextCard;
import com.sdk.wx.cp.bean.MessageSend.MessageVideo;
import com.sdk.wx.cp.bean.MessageSend.MessageVoice;
import com.sdk.wx.cp.storage.InMemoryConfigStorage;
import com.sdk.wx.cp.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 发送消息模块单元测试
 * @author yangtao
 * @date 2019/06/03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SendMessageApiImplTest {
	
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
	
	//发送文本消息
	public void sendMessageText() throws WxErrorException{
		SendMessageApi sendApi = new SendMessageApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		MessageSend msgSend = new MessageSend();
		msgSend.setAgentid(testUtil.getPer().getAuthInfo().getAgent().get(0).getAgentid());
		msgSend.setTouser("YangTao");
		msgSend.setMsgtype("text");
		MessageText text = msgSend.new MessageText();
				text.setContent("测试消息");
		msgSend.setText(text);
		log.info(GsonUtil.create().toJson(sendApi.sendMessage(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), msgSend)));
	}
	
	//发送图片消息
	public void sendMessageImage() throws WxErrorException{
		SendMessageApi sendApi = new SendMessageApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		MessageSend msgSend = new MessageSend();
		msgSend.setAgentid(testUtil.getPer().getAuthInfo().getAgent().get(0).getAgentid());
		msgSend.setTouser("YangTao");
		msgSend.setMsgtype("image");
		MessageImage image = msgSend.new MessageImage();
		image.setMediaId("3kumlQtDs1vfLmYdz1ioy5WURLgmjE7uphSdhoM_xei61yRw_xjlzz7xk6BMulMt5");
		msgSend.setImage(image);;
		log.info(GsonUtil.create().toJson(sendApi.sendMessage(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), msgSend)));
	}
	
	//发送语音消息
	@Test
	public void sendMessageVoice() throws WxErrorException{
		SendMessageApi sendApi = new SendMessageApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		MessageSend msgSend = new MessageSend();
		msgSend.setAgentid(testUtil.getPer().getAuthInfo().getAgent().get(0).getAgentid());
		msgSend.setTouser("YangTao");
		msgSend.setMsgtype("voice");
		MessageVoice voice = msgSend.new MessageVoice();
		voice.setMediaId("3nGkhBAB3uTqax9IET0wPxDT_5qqpEfFjLO341yjy3ew4gkVBpDT12KOVqMkFP6Ye");
		msgSend.setVoice(voice);
		log.info(GsonUtil.create().toJson(sendApi.sendMessage(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), msgSend)));
	}
	
	//发送视频消息
	public void sendMessageVedio() throws WxErrorException{
		SendMessageApi sendApi = new SendMessageApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		MessageSend msgSend = new MessageSend();
		msgSend.setAgentid(testUtil.getPer().getAuthInfo().getAgent().get(0).getAgentid());
		msgSend.setTouser("YangTao");
		msgSend.setMsgtype("video");
		MessageVideo video = msgSend.new MessageVideo();
		video.setMediaId("317sL9bBWwO2nVTew8Y-XRjB9mnmd7SbCo-OHtMl2GyI");
		video.setDescription("这是一段测试视频");
		video.setTitle("测试视频");
		msgSend.setVideo(video);
		log.info(GsonUtil.create().toJson(sendApi.sendMessage(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), msgSend)));
	}
	
	//发送文件消息
	public void sendMessageFile() throws WxErrorException{
		SendMessageApi sendApi = new SendMessageApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		MessageSend msgSend = new MessageSend();
		msgSend.setAgentid(testUtil.getPer().getAuthInfo().getAgent().get(0).getAgentid());
		msgSend.setTouser("YangTao");
		msgSend.setMsgtype("file");
		MessageFile file = msgSend.new MessageFile();
		file.setMediaId("3nwSqQpoLUEBs9SLz-V_1FogtQ6ka5MPW1uBcosvTfDitwuwQ1dy2dMum6SKvikC2");
		msgSend.setFile(file);
		log.info(GsonUtil.create().toJson(sendApi.sendMessage(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), msgSend)));
	}
	
	//发送文本卡片消息
	public void sendMessageTextCard() throws WxErrorException{
		SendMessageApi sendApi = new SendMessageApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		MessageSend msgSend = new MessageSend();
		msgSend.setAgentid(testUtil.getPer().getAuthInfo().getAgent().get(0).getAgentid());
		msgSend.setTouser("YangTao");
		msgSend.setMsgtype("textcard");
		MessageTextCard textcard = msgSend.new MessageTextCard();
		textcard.setBtntext("查看更多");
		textcard.setDescription("这是一条文本卡片消息");
		textcard.setUrl("https://www.baidu.com");
		textcard.setTitle("文本卡片消息");
		msgSend.setTextcard(textcard);
		log.info(GsonUtil.create().toJson(sendApi.sendMessage(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), msgSend)));
	}
	
	//发送图文消息
	public void sendMessageArticle() throws WxErrorException{
		SendMessageApi sendApi = new SendMessageApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		MessageSend msgSend = new MessageSend();
		msgSend.setAgentid(testUtil.getPer().getAuthInfo().getAgent().get(0).getAgentid());
		msgSend.setTouser("YangTao");
		msgSend.setMsgtype("news");
		MessageNews news = msgSend.new MessageNews();
		MessageArticles articles = msgSend.new MessageArticles();
		articles.setDescription("端午节礼品卡");
		articles.setTitle("礼品通知");
		articles.setUrl("https://www.baidu.com");
		articles.setPicurl("http://p.qpic.cn/pic_wework/68696431/fbfdc2eba49cde7138df22e9c10946e4e126ac2776fc408e/0");
		List<MessageArticles> list = new ArrayList<MessageSend.MessageArticles>();
		list.add(articles);
		news.setArticles(list);
		msgSend.setNews(news);
		log.info(GsonUtil.create().toJson(sendApi.sendMessage(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), msgSend)));
	}
	
	//发送图文消息（mpnews）(偏公众号文章之类)
	public void sendMessageMPNews() throws WxErrorException{
		SendMessageApi sendApi = new SendMessageApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		MessageSend msgSend = new MessageSend();
		msgSend.setAgentid(testUtil.getPer().getAuthInfo().getAgent().get(0).getAgentid());
		msgSend.setTouser("YangTao");
		msgSend.setMsgtype("mpnews");
		MessageMPNews news = msgSend.new MessageMPNews();
		MessageMPArticles articles = msgSend.new MessageMPArticles();
		articles.setTitle("mpnews通知");
		articles.setThumbMediaId("3kumlQtDs1vfLmYdz1ioy5WURLgmjE7uphSdhoM_xei61yRw_xjlzz7xk6BMulMt5");
		articles.setAuthor("yangtao");
		articles.setContentSourceUrl("www.baidu.com");
		articles.setContent("这是一条mpnews消息");
		articles.setDigest("mpnews描述");
		List<MessageMPArticles> list = new ArrayList<MessageSend.MessageMPArticles>();
		list.add(articles);
		news.setArticles(list);
		msgSend.setMpnews(news);
		log.info(GsonUtil.create().toJson(sendApi.sendMessage(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), msgSend)));
	}
	
	//发送markdown消息(查看官方文档Markdown语法)
	public void sendMessageMarkdown() throws WxErrorException{
		SendMessageApi sendApi = new SendMessageApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		MessageSend msgSend = new MessageSend();
		msgSend.setAgentid(testUtil.getPer().getAuthInfo().getAgent().get(0).getAgentid());
		msgSend.setTouser("YangTao");
		msgSend.setMsgtype("markdown");
		MessageMarkdown markdown = msgSend.new MessageMarkdown();
		markdown.setContent("您的会议室已经预定，稍后会同步到`邮箱` "+
                ">**事项详情** " +
                ">事　项：<font color=\"info\">开会</font> " +
                ">组织者：@miglioguan " +
                ">参与者：@miglioguan、@kunliu、@jamdeezhou、@kanexiong、@kisonwang " +
                "> " +
                ">会议室：<font color=\"info\">广州TIT 1楼 301</font> " +
                ">日　期：<font color=\"warning\">2018年5月18日</font> " +
                ">时　间：<font color=\"comment\">上午9:00-11:00</font> " +
                "> " +
                ">请准时参加会议。 " +
                "> " +
                ">如需修改会议信息，请点击：[修改会议信息](https://work.weixin.qq.com)");
		msgSend.setMarkdown(markdown);
		log.info(GsonUtil.create().toJson(sendApi.sendMessage(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), msgSend)));
	}
	
	//小程序通知消息
	//TODO 仅小程序可以发送该类型消息
	public void sendMessageMiniprogram() throws WxErrorException{
		SendMessageApi sendApi = new SendMessageApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		MessageSend msgSend = new MessageSend();
		msgSend.setAgentid(testUtil.getPer().getAuthInfo().getAgent().get(0).getAgentid());
		msgSend.setTouser("YangTao");
		msgSend.setMsgtype("markdown");
		MessageMiniprogramNotice mini = msgSend.new MessageMiniprogramNotice();
		mini.setAppid(testUtil.getPer().getAuthCorpInfo().getCorpid());
		mini.setDescription("测试是否可以用第三方应用发送小程序通知消息");
		mini.setTitle("小程序通知消息");
		msgSend.setMiniprogramNotice(mini);
		log.info(GsonUtil.create().toJson(sendApi.sendMessage(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), msgSend)));
	}
	
	//发送任务卡片消息
	public void sendMessageTaskcard() throws WxErrorException{
		SendMessageApi sendApi = new SendMessageApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		MessageSend msgSend = new MessageSend();
		msgSend.setAgentid(testUtil.getPer().getAuthInfo().getAgent().get(0).getAgentid());
		msgSend.setTouser("YangTao");
		msgSend.setMsgtype("taskcard");
		MessageTaskCard taskcard = msgSend.new MessageTaskCard();
		taskcard.setDescription("更新任务卡片消息");
		taskcard.setTitle("更新任务卡片消息");
		taskcard.setTaskId("2");
		MessageBtn btn = msgSend.new MessageBtn();
		btn.setKey("test_update");
		btn.setName("测试update_btn");
		List<MessageBtn> list = new ArrayList<MessageSend.MessageBtn>();
		list.add(btn);
		taskcard.setBtn(list);
		msgSend.setTaskcard(taskcard);
		log.info(GsonUtil.create().toJson(sendApi.sendMessage(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), msgSend)));
	}
	
	//更新任务卡片消息(更改处理状态)
	public void updateTaskCard() throws WxErrorException{
		SendMessageApi sendApi = new SendMessageApiImpl(wechatCommonApi);
		wechatCommonApi.initStorage(inMemoryConfigStorage);
		wechatCommonApi.getConfigStorage().setPermanentCode(suiteId, testUtil.getPer().getAuthCorpInfo().getCorpid(), testUtil.getPer());
		UpdateTaskCardSend taskcardSend = new UpdateTaskCardSend();
		taskcardSend.setAgentid(testUtil.getPer().getAuthInfo().getAgent().get(0).getAgentid());
		taskcardSend.setClickedKey("test_update");
		taskcardSend.setTaskId("2");
		taskcardSend.setUserids(new String[]{"YangTao"});
		log.info(GsonUtil.create().toJson(sendApi.updateTaskCard(suiteId,testUtil.getPer().getAuthCorpInfo().getCorpid(), taskcardSend)));
	}

}

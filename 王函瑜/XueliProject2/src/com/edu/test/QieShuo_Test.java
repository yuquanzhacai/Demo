package com.edu.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.models.Login_Action;
import com.edu.models.QieShuo_Action;

/*
 * author:lixinran
 * modifier:wanghanyu
 * “且说”发表评论
 * 
 */

public class QieShuo_Test extends BaseTest{
	private Login_Action action;
	private QieShuo_Action qaction;
	@BeforeClass
	public void setup()
	{
		action=new Login_Action(webtest);
		qaction=new QieShuo_Action(webtest);
		action.login("952184149@qq.com", "323841Lxr");
	}
	
    @Test(description="发表评论")
    public void comment() throws InterruptedException {        
        qaction.pinglun("#我的话题#发表评论");
    }
    
    @Test(description="发表敏感词汇")
    public void comment2() throws InterruptedException {        
        qaction.pinglun("测试法轮功敏感词");
        Assert.assertTrue(webtest.isTextPresent("请重新输入"));
    }
    
    @Test(description="发表代码评论")
    public void commentCode() throws InterruptedException {
        qaction.pinglundaima("java");
    }
    @Test(description="发表图片评论")
    public void commentPic() throws InterruptedException {
	   qaction.pingluntupian("E:\\1.png");
   }
   @Test(description="发长文")
   public void commentLong() throws InterruptedException{ 
	   qaction.fachengwen("E:\\1.png","标题","正文");
   }
   
   @Test(description="无封面长文")
   public void commentLong_Fail1() throws InterruptedException{ 
	   qaction.fachengwen3("标题","正文");
	   Thread.sleep(2000);
   }
   
   @Test(description="无标题长文")
   public void commentLong_Fail2() throws InterruptedException{ 
	   qaction.fachengwen2("E:\\1.png","","正文");
	   //Assert.assertTrue(webtest.isTextPresent("请输入标题(32个字符以内)"));
   }
   
   @Test(description="无正文长文")
   public void commentLong_Fail3() throws InterruptedException{ 
	   qaction.fachengwen2("E:\\1.png","标题","");
	   //Assert.assertTrue(webtest.isTextPresent("请输入正文"));
   }

}

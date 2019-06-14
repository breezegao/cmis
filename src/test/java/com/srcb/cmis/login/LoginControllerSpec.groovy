package com.srcb.cmis.login

import org.springframework.http.MediaType
import spock.lang.Specification;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
class LoginControllerSpec extends Specification{

    def "test LoginController.login()"(){
        given:"mockMvc is created by LoginController"
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new LoginController()).build();
        when:"login is called"
        def mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/login")
                .accept(MediaType.ALL)) //数据类型
                .andDo(MockMvcResultHandlers.print())   //打印处理内容
                .andReturn();                    //返回结果
        def vieName = mvcResult.getModelAndView().getViewName();  //取出视图名称
        then:"should return view name: security/login"
        vieName == "security/login"
    }

    def "test LoginController.index()"(){
        given:"mockMvc is created by LoginController"
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new LoginController()).build();
        when:"index is called"
        def mvcResult= mockMvc.perform(MockMvcRequestBuilders.post("/index")
                .accept(MediaType.ALL))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        def responseMessage = mvcResult.getResponse().getContentAsString()
        then:"should return :register success"
        responseMessage == "register success!"
    }

    def "test LoginController.welcome()"(){
        given:"mockMvc is created by LoginController"
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new LoginController()).build();
        when:"welcome is called"
        def mvcResult= mockMvc.perform(MockMvcRequestBuilders.post("/welcome")
                .param("userName","Jack")
                .param("password","123456")
                .accept(MediaType.ALL))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        def responseMessage = mvcResult.getResponse().getContentAsString()
        then:"should return:Hello,Jack"
        responseMessage == "Hello,Jack"
    }
}

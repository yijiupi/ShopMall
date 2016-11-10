package admin.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import admin.swagger.SwaggerInput;
import admin.swagger.SwaggerOutput;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController  
@RequestMapping(value = "/swaggerTest")  
public class SwaggerController {  
       
    @ResponseBody  
    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)  
    @ApiOperation(nickname = "swagger-helloworld", value = "Swagger的世界", notes = "测试HelloWorld")  
    public String helloWorld(@ApiParam(value = "昵称") @RequestParam String nickname) {  
        return "Hello world, " + nickname;  
    }  
       
    @ResponseBody  
    @RequestMapping(value = "/objectio", method = RequestMethod.POST)  
    @ApiOperation(nickname = "swagger-objectio", value = "Swagger的ObjectIO", notes = "测试对象输入输出")  
    public SwaggerOutput objectIo(@ApiParam(value = "输入") @RequestBody SwaggerInput input) {  
        SwaggerOutput output = new SwaggerOutput();  
        output.setId(input.getId());  
        output.setName("Swagger");  
        return output;  
    }  
}

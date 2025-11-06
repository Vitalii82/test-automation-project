import io.qameta.allure.*;
package com.example.api;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import org.apache.http.HttpStatus;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
@Endpoint(url = "${base_url}/get", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpStatus.SC_OK)
@RequestTemplatePath(path = "api/get/get_echo_req.json")
@ResponseTemplatePath(path = "api/get/get_echo_rs.json")
public class GetEchoMethod extends AbstractApiMethodV2 {
  public GetEchoMethod() { replaceUrlPlaceholder("base_url", Configuration.getRequired("base_url")); }
}
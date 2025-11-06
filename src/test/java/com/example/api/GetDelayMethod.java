import io.qameta.allure.*;
package com.example.api;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import org.apache.http.HttpStatus;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
@Endpoint(url = "${base_url}/delay/${sec}", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpStatus.SC_OK)
public class GetDelayMethod extends AbstractApiMethodV2 {
  public GetDelayMethod(int sec) {
    replaceUrlPlaceholder("base_url", Configuration.getRequired("base_url"));
    replaceUrlPlaceholder("sec", String.valueOf(sec));
  }
}
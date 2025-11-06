package com.example.api;

import io.qameta.allure.*;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
@Endpoint(url = "${base_url}/status/${code}", methodType = HttpMethodType.GET)
public class GetStatusMethod extends AbstractApiMethodV2 {
  public GetStatusMethod(int code) {
    replaceUrlPlaceholder("base_url", Configuration.getRequired("base_url"));
    replaceUrlPlaceholder("code", String.valueOf(code));
  }
}
package com.example.api;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import org.apache.http.HttpStatus;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
@Endpoint(url = "${base_url}/uuid", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpStatus.SC_OK)
public class GetUUIDMethod extends AbstractApiMethodV2 {
  public GetUUIDMethod() { replaceUrlPlaceholder("base_url", Configuration.getRequired("base_url")); }
}
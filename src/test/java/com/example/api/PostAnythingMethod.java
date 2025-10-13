package com.example.api;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import org.apache.http.HttpStatus;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
@Endpoint(url = "${base_url}/anything", methodType = HttpMethodType.POST)
@SuccessfulHttpStatus(status = HttpStatus.SC_OK)
@RequestTemplatePath(path = "api/post/anything_req.json")
@ResponseTemplatePath(path = "api/post/anything_rs.json")
public class PostAnythingMethod extends AbstractApiMethodV2 {
  public PostAnythingMethod() { replaceUrlPlaceholder("base_url", Configuration.getRequired("base_url")); }
}
package com.example.tests.declarative;
import com.example.api.*;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class HttpBinDeclarativeTest {
  @Test(groups="declarative")
  public void getEcho_shouldReturn200(){ AbstractApiMethodV2 api=new GetEchoMethod(); var rs=api.callAPIExpectSuccess(); assertEquals(rs.statusCode(),200); }
  @Test(groups="declarative")
  public void getUUID_shouldReturnUUID(){ var rs=new GetUUIDMethod().callAPIExpectSuccess(); assertTrue(rs.asString().contains("uuid")); }
  @Test(groups="declarative")
  public void postAnything_shouldEchoJson(){ var rs=new PostAnythingMethod().callAPIExpectSuccess(); String body=rs.asString(); assertTrue(body.contains(""id": 1001")); assertTrue(body.contains(""name": "carina"")); }
  @Test(groups="declarative")
  public void getDelay_1sec_shouldReturn200(){ var rs=new GetDelayMethod(1).callAPIExpectSuccess(); assertEquals(rs.statusCode(),200); }
  @Test(groups="declarative")
  public void getStatus_418_shouldReturn418(){ var api=new GetStatusMethod(418); var rs=api.callAPI(); assertEquals(rs.statusCode(),418); }
}
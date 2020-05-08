package com.onevizion.uitest.api.restapi;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onevizion.uitest.api.SeleniumSettings;
import com.onevizion.uitest.api.exception.SeleniumUnexpectedException;

@Component
public class CreateTestResult {

    private static final String TRACKOR_TYPE_NAME = "SELENIUM_TEST_RESULT";
    private static final String PARENT_TRACKOR_TYPE_NAME_TEST = "SELENIUM_TEST";
    private static final String PARENT_TRACKOR_TYPE_NAME_PROCESS = "SELENIUM_PROCESS";

    @Resource
    private SeleniumSettings seleniumSettings;

    public String create(String process, String testName, String bugs) {
        try {
            URL url = new URL(seleniumSettings.getRestApiUrl() + "/api/v3/trackor_types/" + TRACKOR_TYPE_NAME + "/trackors");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Basic " + seleniumSettings.getRestApiCredential());

            String input = "{ " + 
                    "   \"fields\": { " + 
                    "     \"STR_STATUS\": \"in progress\", " + 
                    "     \"STR_BUGS\": \"" + bugs + "\" " + 
                    "   }, " + 
                    "   \"parents\": [ " + 
                    "     { " + 
                    "       \"trackor_type\": \"" + PARENT_TRACKOR_TYPE_NAME_TEST + "\", " + 
                    "       \"filter\": { " + 
                    "         \"XITOR_KEY\": \"\\\"" + testName + "\\\"\" " + 
                    "       } " + 
                    "     }, " + 
                    "     { " + 
                    "       \"trackor_type\": \"" + PARENT_TRACKOR_TYPE_NAME_PROCESS + "\", " + 
                    "       \"filter\": { " + 
                    "         \"XITOR_KEY\": \"\\\"" + process + "\\\"\" " + 
                    "       } " + 
                    "     } " + 
                    "   ] " + 
                    " }";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new SeleniumUnexpectedException("CreateTestResult.create Failed : HTTP error code : " + conn.getResponseCode() + " HTTP error message : " + conn.getResponseMessage());
            }

            String result = IOUtils.toString(conn.getInputStream(), StandardCharsets.UTF_8.toString());

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(result);
            String trackorKey = jsonNode.path("TRACKOR_KEY").asText();

            conn.disconnect();

            return trackorKey;
        } catch (Exception e) {
            throw new SeleniumUnexpectedException(e);
        }
    }

    public void update(String trackorKey, String testStatus, String testResultNode, String testLog,
            String profiler, String profilerTestMethods, double runtimeTestMethods,
            String errorReport, String errorCallstack, String errorScreenshot) {
        try {
            profiler = profiler.replaceAll("\\\\", "\\\\\\\\");
            profiler = profiler.replaceAll("\\n", "\\\\n");
            profiler = profiler.replaceAll("\\t", "\\\\t");
            profiler = profiler.replaceAll("\\r", "\\\\r");
            profiler = profiler.replaceAll("\"", "'");

            profilerTestMethods = profilerTestMethods.replaceAll("\\\\", "\\\\\\\\");
            profilerTestMethods = profilerTestMethods.replaceAll("\\n", "\\\\n");
            profilerTestMethods = profilerTestMethods.replaceAll("\\t", "\\\\t");
            profilerTestMethods = profilerTestMethods.replaceAll("\\r", "\\\\r");
            profilerTestMethods = profilerTestMethods.replaceAll("\"", "'");

            runtimeTestMethods = (double) runtimeTestMethods / 1_000_000_000;
            runtimeTestMethods = (double) Math.round(runtimeTestMethods * 1000) / 1000;

            URL url = new URL(seleniumSettings.getRestApiUrl() + "/api/v3/trackor_types/" + TRACKOR_TYPE_NAME + "/trackors?" + TRACKOR_TYPE_NAME +".TRACKOR_KEY=%22" + trackorKey + "%22");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Basic " + seleniumSettings.getRestApiCredential());

            String input;
            if ("fail".equals(testStatus)) {
                if (errorScreenshot != null) {
                    input = "{ " + 
                            "   \"fields\": { " + 
                            "     \"STR_STATUS\": \"" + testStatus + "\", " + 
                            "     \"STR_NODE\": \"" + testResultNode + "\", " + 
                            "     \"STR_ERROR_LOG\": \"" + testLog + "\", " + 
                            "     \"STR_PROFILER\": \"" + profiler + "\", " + 
                            "     \"STR_PROFILER_TEST_METHODS\": \"" + profilerTestMethods + "\", " + 
                            "     \"STR_RUNTIME_TEST_METHO_SECONDS\": \"" + runtimeTestMethods + "\", " + 
                            "     \"STR_ERROR_REPORT\": \"" + errorReport + "\", " + 
                            "     \"STR_ERROR_CALLSTACK\": \"" + errorCallstack + "\", " + 
                            "     \"STR_ERROR_FILE\": {\"file_name\": \"screenshot.jpg\", \"data\": \"" + errorScreenshot + "\"} " + 
                            "   } " + 
                            " }";
                } else {
                    input = "{ " + 
                            "   \"fields\": { " + 
                            "     \"STR_STATUS\": \"" + testStatus + "\", " + 
                            "     \"STR_NODE\": \"" + testResultNode + "\", " + 
                            "     \"STR_ERROR_LOG\": \"" + testLog + "\", " + 
                            "     \"STR_PROFILER\": \"" + profiler + "\", " + 
                            "     \"STR_PROFILER_TEST_METHODS\": \"" + profilerTestMethods + "\", " + 
                            "     \"STR_RUNTIME_TEST_METHO_SECONDS\": \"" + runtimeTestMethods + "\", " + 
                            "     \"STR_ERROR_REPORT\": \"" + errorReport + "\", " + 
                            "     \"STR_ERROR_CALLSTACK\": \"" + errorCallstack + "\" " + 
                            "   } " + 
                            " }";
                }
            } else {
                input = "{ " + 
                        "   \"fields\": { " + 
                        "     \"STR_STATUS\": \"" + testStatus + "\", " + 
                        "     \"STR_NODE\": \"" + testResultNode + "\", " + 
                        "     \"STR_ERROR_LOG\": \"" + testLog + "\", " + 
                        "     \"STR_PROFILER\": \"" + profiler + "\", " + 
                        "     \"STR_PROFILER_TEST_METHODS\": \"" + profilerTestMethods + "\", " + 
                        "     \"STR_RUNTIME_TEST_METHO_SECONDS\": \"" + runtimeTestMethods + "\" " + 
                        "   } " + 
                        " }";
            }

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new SeleniumUnexpectedException("CreateTestResult.update Failed : HTTP error code : " + conn.getResponseCode() + " HTTP error message : " + conn.getResponseMessage());
            }

            conn.disconnect();
        } catch (Exception e) {
            throw new SeleniumUnexpectedException(e);
        }
    }

}
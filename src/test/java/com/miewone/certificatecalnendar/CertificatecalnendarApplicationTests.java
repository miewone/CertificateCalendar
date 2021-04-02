package com.miewone.certificatecalnendar;

import com.miewone.certificatecalnendar.domains.certificate.domain.qnetCertificateEntity;
import com.miewone.certificatecalnendar.domains.certificate.service.CallApiOfCertificate;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CertificatecalnendarApplicationTests {
    @Autowired
    private CallApiOfCertificate callApiOfCertificate;

    @LocalServerPort
    private int port;

    RestTemplate client = new RestTemplate();
    @Test
    void contextLoads() throws IOException, ParseException, IllegalAccessException {

        callApiOfCertificate.callApi_qnet();
    }
    @DisplayName("1.자격증 정보 API로 호출하기")
    @Test
    void  apiGetCall()
    {
        String url = "http://localhost:"+port+"/api/certificate";

        ResponseEntity<qnetCertificateEntity> entity = client.getForEntity(url,qnetCertificateEntity.class);
//        List<qnetCertificateEntity> t = entity.getBody();
    }
}

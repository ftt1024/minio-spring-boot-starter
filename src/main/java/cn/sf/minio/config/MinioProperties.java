package cn.sf.minio.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "cn.minio")
public class MinioProperties {
    private String endpoint;
    private String accessKey;
    private String secretKey;
}

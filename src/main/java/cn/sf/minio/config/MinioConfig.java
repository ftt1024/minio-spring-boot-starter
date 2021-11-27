package cn.sf.minio.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Slf4j
@Configuration
@ConditionalOnClass(MinioClient.class)
@ConditionalOnMissingBean(MinioClient.class)
@EnableConfigurationProperties(MinioProperties.class)
public class MinioConfig {

    private MinioClient minioClient;

    @Resource
    private MinioProperties properties;

    @Bean
    public MinioClient minioClient() throws InvalidPortException, InvalidEndpointException, JsonProcessingException {
        log.info("Minio properties:{}", properties.toString());
        try {
            minioClient = new MinioClient(properties.getEndpoint(), properties.getAccessKey(), properties.getSecretKey());
            log.info("minioClient is {}", minioClient.toString());
        } catch (Throwable e) {
            log.error("文件服务客户端初始化失败，文件服务不可用", e);
            throw e;
        }
        return minioClient;
    }

}

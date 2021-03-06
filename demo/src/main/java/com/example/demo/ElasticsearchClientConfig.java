package com.example.demo;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.amazonaws.auth.AWSStaticCredentialsProvider;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.demo")
@ComponentScan(basePackages = { "com.example.demo" })
public class ElasticsearchClientConfig {
	private static final String HOST = "search-product-es-u4jrwstj4ev36wkjhbmhlv6odm.ap-south-1.es.amazonaws.com"; // localhost
	private static final int PORT = 443; // 9092
	private static final String PROTOCOL = "https"; // http

	@Bean
	public RestHighLevelClient client() {
		final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY,
				new UsernamePasswordCredentials("AKIAQ45S57MVVRCR7UXC", "I4CAoDIRXvtGJmqTVWAR6BEQ5oijPCSMziNzUo90"));
//		AWSStaticCredentialsProvider awsCreds = AWSStaticCredentialsProvider.create("AKIAQ45S57MVVRCR7UXC",
//				"I4CAoDIRXvtGJmqTVWAR6BEQ5oijPCSMziNzUo90");
		RestClientBuilder builder = RestClient.builder(new HttpHost(HOST, PORT, PROTOCOL))
				.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
					@Override
					public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
						return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
					}
				});
		RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);
		return restHighLevelClient;
	}

//	  @Value("${elasticsearch.host}")
//	    private String elasticsearchHost;
//	@Override
//	@Bean
//	public RestHighLevelClient elasticsearchClient() {
////		RestClient restClient = RestClient.builder(
////			    new HttpHost("search-test-elasti-xxxx-xxxxx.us-east-1.es.amazonaws.com", 80, "http")).build();
////			RestHighLevelClient restHighLevelClient = new RestHighLevelClient(restClient);
////			return restHighLevelClient;
//
////        RestHighLevelClient client = new RestHighLevelClient(
////                RestClient.builder(new HttpHost(elasticsearchHost)));
////
////        return client;
//////		
////		final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//				.connectedTo("search-product-es-u4jrwstj4ev36wkjhbmhlv6odm.ap-south-1.es.amazonaws.com:443").build();
//		System.out.println(clientConfiguration);
//		return RestClients.create(clientConfiguration).rest();
//	}
}
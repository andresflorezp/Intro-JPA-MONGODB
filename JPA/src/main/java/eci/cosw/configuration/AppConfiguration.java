package eci.cosw.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class AppConfiguration {

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {

		MongoClientURI uri = new MongoClientURI(
				"mongodb://admin:admin@cluster-jpa-shard-00-00-fgk5q.mongodb.net:27017,cluster-jpa-shard-00-01-fgk5q.mongodb.net:27017,cluster-jpa-shard-00-02-fgk5q.mongodb.net:27017/test?ssl=true&replicaSet=cluster-jpa-shard-0&authSource=admin&retryWrites=true&w=majority");

		MongoClient mongoClient = new MongoClient(uri);

		return new SimpleMongoDbFactory(mongoClient, "test");

	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

		return mongoTemplate;

	}

}
package org.soyphea.springoauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
@Profile("redis")
public class AuthRedisServerConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	RedisConnectionFactory redisConnectionFactory;

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).tokenEnhancer(tokenEnhancer())
				.tokenStore(redisTokenStore());

	}

	@Bean
	public TokenStore redisTokenStore() {
		return new RedisTokenStore(redisConnectionFactory);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()")
				.checkTokenAccess("permitAll()");
	}

/*	@Override
	@Profile("memory")
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.inMemory().withClient("test1").secret("secret").authorizedGrantTypes("client_credentials", "password")
				.authorities("ADMIN").scopes("user").autoApprove(true).accessTokenValiditySeconds(36000)
				.resourceIds("resource1");
	}
*/

  // IN memory clients store
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.inMemory()
				.withClient("fooClientIdPassword")
				.authorizedGrantTypes("client_credentials", "password")
				.authorities("ROLE_ADMIN", "ROLE_TRUSTED_CLIENT")
				.scopes("read", "write", "trust")
				.secret("secret")
				.accessTokenValiditySeconds(120)
				.refreshTokenValiditySeconds(600);
	}

	@SuppressWarnings("deprecation")

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public TokenEnhancer tokenEnhancer() {
		return new CustomTokenEnhancer();
	}
}

//package com.example.api_gateway.filter;
//
//import io.jsonwebtoken.Jwts;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ResponseStatusException;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Component
//public class JwtTokenGlobalFilter implements GlobalFilter, Ordered {
//
//    @Value("${json-web-token.secret-key}")
//    private String secretKey;
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String path = exchange.getRequest().getPath().toString();
//        if(path.startsWith("/category/")){
//            return chain.filter(exchange);
//        }
//
//        if(path.equals("/user/signup") || path.equals("user/signin")) {
//            return chain.filter(exchange);
//        }
//
//        if(path.equals("/comment/jwtTest2")) {
//            return chain.filter(exchange);
//        }
//
//        String jwtToken = exchange.getRequest().getHeaders().getFirst("Authorization");
//        if(jwtToken == null) {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Jwt Token is missing");
//        }
//
//        try {
//            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(jwtToken.replace("Bearer ", ""));
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Token");
//        }
//
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}

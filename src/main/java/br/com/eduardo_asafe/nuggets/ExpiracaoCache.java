package br.com.eduardo_asafe.nuggets;

public class ExpiracaoCache {
    /**
     *
     * 1. TTL
     *
     * @Configuration
     * @EnableCaching
     * public class CacheConfig {
     *     @Bean
     *     public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
     *         RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
     *                 .entryTtl(Duration.ofMinutes(10));
     *         return RedisCacheManager.builder(connectionFactory)
     *                 .cacheDefaults(config)
     *                 .build();
     *     }
     * }
     * Prós: simplicidade.
     * Contra: sistema pode fornecer cache antigo por um curto periodo de tempo.
     *
     *
     * 2. Padrão cache-aside
     * @Cacheable(value = "products", key = "#id")
     * public Product getProduct(String id) {
     *     return productRepository.findById(id).orElseThrow();
     * }
     *
     * @CacheEvict(value = "products", key = "#id")
     * public void updateProduct(Product product) {
     *     productRepository.save(product);
     * }
     *
     * Prós: Funciona bem para aplicaçãoes monoliticas.
     * Contra: Em aplicação distribuidas apenas o nó que teve alteração será atualizado.
     *
     * 3. Chave de Cache Versionadas
     * product:123:v1
     * product:123:v2
     *
     * public String buildCacheKey(String productId, int version) {
     *     return "product:" + productId + ":v" + version;
     * }
     *
     * Prós: Ideal para aplicações com alto processamento que não depende de ordem.
     * Contra: Necessário implementar rotina de limpeza de versões antigas e obsoletas.
     *
     */

}

# VHT test project for candidate

## Requirements

- Create a Spring Boot application with a simple service (e.g., fetching user details).
- Implement caching using Spring's caching abstraction.
- Configure a cache provider (e.g., EhCache, Redis).
- Demonstrate the caching functionality by showing the difference in response times for cached vs. non-cached requests

## Implement

### Setting Up the Spring Boot Project

- Java 17
- Spring boot 3.3.1-SNAPSHOT
- Spring data jpa and hibernate: Simplify the mapping of database tables to Java objects effortlessly.
- Spring cache: Easily configured to automatically handle caching with annotations or through manual processes.
- Redisson to integrate redis: Flexible configuration options for Redis cache using sentinelServersConfig or singleServerConfig.
- Mysql 8.0.
- Redis latest version (standalone).

### Comparison of Query Data with Cache vs. Non-Cache

- Create two APIs: One API for querying user data with cache, another API for querying user data without cache.
- Benchmark tool: JMeter.
- Benchmark script: Configure JMeter to send 25, 50, 100, 200, 400, 800, and 1600 requests within 5 seconds to each API.
- Record the query response times in milliseconds to a file.
- Calculate the average execution time for each type of query (with cache and without cache).
- Result: Present the average execution time for each query type (in milliseconds)

| Script (reqs/seconds) | Query with cache | Query without cache |
|-----------------------|------------------|---------------------|
| 25/5                  | 2.92             | 7.44                |
| 50/5                  | 3.44             | 8.48                |
| 100/5                 | 2.91             | 8.51                |
| 200/5                 | 2.415            | 7.205               |
| 400/5                 | 2.1775           | 6.87                |
| 800/5                 | 1.93125          | 7.46125             |
| 1600/5                | 2.969375         | 169.443125          |


### Conclusion

- Using cache is always faster than querying.
- When the TPS (transactions per second) is higher, query time becomes very slow, but the cache remains very fast and stable.


package hello.itemservice.config;

import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.jpa.JpaItemRepositoryV3;
import hello.itemservice.repository.v2.ItemQueryRepositoryV2;
import hello.itemservice.repository.v2.ItemRepositoryV2;
import hello.itemservice.service.ItemService;
import hello.itemservice.service.ItemServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class V2Config {

    private final EntityManager em;
    private final ItemRepositoryV2 itemRepositoryV2; //Spring Data Jpa가 제공함

    @Bean
    public ItemService itemService() {
        return new ItemServiceV2(itemRepositoryV2, ItemQueryRepositoryV2());
    }
    @Bean
    public ItemQueryRepositoryV2 ItemQueryRepositoryV2() {
        return new ItemQueryRepositoryV2(em);
    }
    @Bean
    public ItemRepository itemRepository() {
        // 여기선 Test들이 ItemRepository기준으로 되어있어서 넣은거임.
        return new JpaItemRepositoryV3(em);
    }

}

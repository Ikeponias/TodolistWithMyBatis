package com.ikeda;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

  @Bean
  public Docket swaggerSpringMvcPlugin() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("sample-api") // APIドキュメントをグルーピングするための識別名
        .select().paths(paths()).build().apiInfo(apiInfo());
  }

  private Predicate<String> paths() {
    // ドキュメント生成の対象とするAPIのURLを指定
    // この場合、「/user」で始まるAPIがドキュメント生成対象となる
    return Predicates.or(Predicates.containsPattern("/todo"));
  }

  private ApiInfo apiInfo() {
    return new ApiInfo("Sample TODO API" // APIのタイトル
        , "このAPIはサンプルです" // APIの説明
        , "V1" // APIのバージョン
        , "テスト" // 利用規約のURL
        , new Contact("株式会社ほげほげ" // APIに関する連絡先組織・団体等
            , "http://hoge.co.jp" // APIに関する連絡先組織・団体等のWeb Site Url
            , "hoge@example.jp") // APIに関する連絡先組織・団体等のメールアドレス
        , "API LICENSE" // APIのライセンス
        , "http://foobar.co.jp" // APIのライセンスURL
        , new ArrayList<VendorExtension>() // 独自に拡張したいドキュメントがあればここで作成
    );
  }
}
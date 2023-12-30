package com.k2.example.examplespringbatch;

import java.util.UUID;
import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Bean
    public Job job(JobRepository jobRepository, Step step) {
        return new JobBuilder("job", jobRepository)
            .start(step)
            .build();
    }

    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager, DataSource dataSource) {
        return new StepBuilder("step", jobRepository)
            .<Coffee, Coffee>chunk(10, transactionManager)
            .reader(reader())
            .processor(itemProcessor())
            .writer(writer(dataSource))
            .build();
    }

    @Bean
    public FlatFileItemReader<Coffee> reader() {
        return new FlatFileItemReaderBuilder<Coffee>()
            .name("reader")
            .resource(new ClassPathResource("coffe-list.csv"))
            .comments("--")
            .delimited()
            .names("brand", "origin", "characteristics")
            .targetType(Coffee.class)
            .build();
    }

    @Bean
    public ItemProcessor<Coffee, Coffee> itemProcessor() {
        // Se necessário, adicione um ItemProcessor para processar os dados lidos antes de escrever no banco de dados
        return item -> {
            item.setHashCode(UUID.randomUUID().toString());
            return item;
        };
    }

    @Bean
    public JdbcBatchItemWriter<Coffee> writer(DataSource dataSource) {
        JdbcBatchItemWriter<Coffee> writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO coffee (brand, origin, characteristics, hashCode) VALUES (:brand, :origin, :characteristics, :hashCode)");
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return writer;
    }
}

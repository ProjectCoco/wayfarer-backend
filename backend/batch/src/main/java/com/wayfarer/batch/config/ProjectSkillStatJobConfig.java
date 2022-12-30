package com.wayfarer.batch.config;

import com.wayfarer.batch.domain.TestResult;
import com.wayfarer.project.entity.ProjectArticle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Configuration
public class ProjectSkillStatJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final EntityManagerFactory entityManagerFactory;

    public ProjectSkillStatJobConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, EntityManagerFactory entityManagerFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.entityManagerFactory = entityManagerFactory;
    }

    @Bean
    public Job ExampleJob() throws Exception {

        Job exampleJob = jobBuilderFactory.get("exampleJob")
                .start(Step1())
                .next(Step2())
                .build();

        return exampleJob;
    }

    @Bean
    @JobScope
    public Step Step1() throws Exception {
        return stepBuilderFactory.get("Step1")
                .<ProjectArticle, TestResult>chunk(10)
                .reader(reader1())
                .writer(writer1())
                .build();
    }

    @Bean
    @JobScope
    public Step Step2() throws Exception {
        return stepBuilderFactory.get("Step2")
                .<ProjectArticle, TestResult>chunk(10)
                .reader(reader2())
                .processor(processor2())
                .writer(writer2())
                .build();
    }

    @Bean
    @StepScope
    public JpaPagingItemReader<ProjectArticle> reader1() throws Exception {

        Map<String, Object> parameterValues = new HashMap<>();
        parameterValues.put("time", LocalDate.now());

        return new JpaPagingItemReaderBuilder<ProjectArticle>()
                .pageSize(10)
                .parameterValues(parameterValues)
                .queryString("SELECT p FROM ProjectArticle p WHERE formatdatetime(p.createdTime,'yyyy-MM-dd')=:time")
                .entityManagerFactory(entityManagerFactory)
                .name("JpaPagingItemReader")
                .build();
    }

    @Bean
    @StepScope
    public ItemProcessor<ProjectArticle, TestResult> processor2() {

        return new ItemProcessor<ProjectArticle, TestResult>() {
            @Override
            public TestResult process(ProjectArticle projectArticle) throws Exception {
                //비즈니스 logic
                List<String> skills = projectArticle.getProjectSkills();
                for (String s: skills) {

                }
                return new TestResult();
            }
        };
    }
    @Bean
    @StepScope
    public ItemWriter writer1() {
        return ItemWriter;
    }

    @Bean
    @StepScope
    public JpaItemWriter<TestResult> writer2() {
        return new JpaItemWriterBuilder<TestResult>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }
}
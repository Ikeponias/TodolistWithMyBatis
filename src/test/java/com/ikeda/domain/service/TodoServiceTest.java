package com.ikeda.domain.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {
  @Mock
  private TodoService todoService;

  @Before
  public void setUp() {
  }

  @Test
  public void データの挿入() {
    Mockito.when(todoService.save(Mockito.any())).thenReturn(true);

    // 実行
    final Boolean isSuccess = todoService.save(Mockito.any());

    // 検証
    assertThat(isSuccess).isEqualTo(true);
  }

  @Test
  public void データの削除() {
    Mockito.when(todoService.delete(Mockito.any())).thenReturn(true);

    // 実行
    final Boolean isSuccess = todoService.delete(Mockito.any());

    // 検証
    assertThat(isSuccess).isEqualTo(true);
  }
}
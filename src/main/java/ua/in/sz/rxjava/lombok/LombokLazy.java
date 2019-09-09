package ua.in.sz.rxjava.lombok;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Builder
public class LombokLazy {
    @Builder.Default
    private List<String> foo = new ArrayList<>();
}

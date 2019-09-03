package ua.in.sz.rxjava.core.impl;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor(staticName = "of")
public class EventDto {
    private final String name;
    private final int no;
}

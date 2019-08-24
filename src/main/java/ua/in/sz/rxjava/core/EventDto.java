package ua.in.sz.rxjava.core;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor(staticName = "of")
class EventDto {
    private final String name;
    private final int no;
}

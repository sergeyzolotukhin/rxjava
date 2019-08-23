package ua.in.sz.rxjava.core;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor(staticName = "of")
public class EventDto {
    private final String name;
    private final int no;
}

package com.godnedy.address.parse;

public interface ParsingStrategyFactory {

    ParsingStrategy getParsingStrategy(String strategyName);
}

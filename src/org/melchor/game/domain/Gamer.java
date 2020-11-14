package org.melchor.game.domain;

import org.melchor.game.dto.BaseBallNumbers;

/**
 * 숫자 야구를 하는 게이머가 공통으로 가져야할 메서드를 정의한 인터페이스입니다.
 */
public interface Gamer {
    BaseBallNumbers getBaseBallNumbers();
}

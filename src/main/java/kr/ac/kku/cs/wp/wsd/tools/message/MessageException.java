/*
 * Copyright (C) 2024 Kiseok Jang. All rights reserved.
 *
 * This software is licensed under the Personal and Limited Commercial Use License.
 * You may use this software for personal, educational, or non-commercial purposes.
 * For commercial use, ensure that your use does not infringe on the rights of others.
 *
 * For full license details, see the LICENSE file in the root directory of this project.
 *
 * Contact information: lecture4cs@gmail.com
 * 
 * 
 * 
 * 저작권 (C) 2024 장기. 모두의 권리 보유.
 *
 * 이 소프트웨어는 개인 및 제한적인 상업적 사용 라이선스 하에 제공됩니다.
 * 이 소프트웨어는 개인적, 교육적 또는 비상업적 모드로 자유로 사용할 수 있습니다.
 * 상업적 사용을 위해서는 타인의 권리를 침해하지 않도록 주의해야 합니다.
 *
 * 전체 라이선스 내용은 이 프리젝트의 루트 디렉토리에 있는 LICENSE 파일을 참조하시오.
 *
 * 연락처: lecture4cs@gmail.com
 * 
 */
package kr.ac.kku.cs.wp.wsd.tools.message;

/**
 * MessageException
 * 
 * @author kiseokjang
 * @since 2024. 10. 2.
 * @version 1.0
 */
public class MessageException extends RuntimeException {

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public MessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // Perform additional logging or initialize custom fields.
        System.err.println("[MessageException] Detailed constructor invoked: " + message);
    }

    /**
     * @param message
     * @param cause
     */
    public MessageException(String message, Throwable cause) {
        super(message, cause);
        // Log or handle specific cases for message and cause.
        System.err.println("[MessageException] Message and cause constructor invoked: " + message);
    }

    /**
     * @param message
     */
    public MessageException(String message) {
        super(message);
        // Log the message or take a default action.
        System.err.println("[MessageException] Message constructor invoked: " + message);
    }

    /**
     * @param cause
     */
    public MessageException(Throwable cause) {
        super(cause);
        // Handle throwable cases, e.g., null checks or custom recovery.
        System.err.println("[MessageException] Cause constructor invoked: " + cause);
    }
}

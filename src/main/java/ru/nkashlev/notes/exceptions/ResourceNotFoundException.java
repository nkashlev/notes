package ru.nkashlev.notes.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}

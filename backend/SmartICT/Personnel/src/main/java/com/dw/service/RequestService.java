package com.dw.service;

import com.dw.dto.RequestLog;
import com.dw.dto.RequestLogResponse;
import com.dw.enums.STATUS;
import com.dw.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;

    public List<RequestLogResponse> getRequestLogs() {
        return this.requestRepository.findAllByOrderByDateAsc()
                .stream()
                .map(RequestLogResponse::fromRequest)
                .collect(Collectors.toList());
    }

    public List<RequestLogResponse> getRequestLogsByEntity(String entityName) {
        return this.requestRepository.findByEntityNameOrderByDateAsc(entityName)
                .stream()
                .map(RequestLogResponse::fromRequest)
                .collect(Collectors.toList());
    }

    public List<RequestLogResponse> getRequestLogsByEntityAndId(String entityName, String id) {
        return this.requestRepository.findByEntityNameAndEntityIdOrderByDateAsc(entityName, id)
                .stream()
                .map(RequestLogResponse::fromRequest)
                .collect(Collectors.toList());
    }

    public List<RequestLogResponse> getLogsByStatus(int status) {
        return this.requestRepository.findByStatusOrderByDateAsc(STATUS.getStatus(status))
                .stream()
                .map(RequestLogResponse::fromRequest)
                .collect(Collectors.toList());
    }

    public RequestLogResponse createRequestLog(RequestLog requestLog) {
        return RequestLogResponse.fromRequest(
                this.requestRepository.save(requestLog.toRequest()));
    }

    public void deleteAllRequestLogs() {
        this.requestRepository.deleteAll();
    }
}

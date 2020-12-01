package com.thoughtworks.aceleradora.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.thoughtworks.aceleradora.controller.request.EstimateRequest;
import com.thoughtworks.aceleradora.entity.Estimate;
import com.thoughtworks.aceleradora.repository.EstimateRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstimateService {

    private EstimateRepository estimateRepository;
    private EstimateConverterService estimateConverterService;
    private MailFactory mailFactory;

    EstimateService(EstimateRepository repository, EstimateConverterService estimateConverter, MailFactory mailFactory) {
        this.estimateRepository = repository;
        this.estimateConverterService = estimateConverter;
        this.mailFactory=mailFactory;
    }

    public Estimate create(EstimateRequest estimateRequest) {
        Estimate estimateEntity = estimateConverterService.converter(estimateRequest);
        return estimateRepository.save(estimateEntity);
    }

    public Optional<Estimate> getEstimate(int codigo) {
        return estimateRepository.findById(codigo);
    }

    private void sendEstimateEmail(Estimate estimateEntity){
        StringBuffer sb =new StringBuffer();
        sb.append("NOVO ORÇAMENTO: ");
        sb.append( System.getProperty("line.separator"));
        sb.append( System.getProperty("line.separator"));

        sb.append("Requisitante: ");
        sb.append(estimateEntity.getRequester().getFullName());
        sb.append( System.getProperty("line.separator"));

        sb.append("Telefone: ");
        sb.append(estimateEntity.getRequester().getCellphone());
        sb.append( System.getProperty("line.separator"));


        sb.append("Email: ");
        sb.append(estimateEntity.getRequester().getEmail());
        sb.append( System.getProperty("line.separator"));

        sb.append("Cep: ");
        sb.append(estimateEntity.getResidueAddress().getCep());
        sb.append( System.getProperty("line.separator"));

        sb.append("Informações do local: ");
        sb.append(estimateEntity.getResidueAddress().getLocationInfo());
        sb.append( System.getProperty("line.separator"));

        sb.append("Informações do residuo: ");
        sb.append(estimateEntity.getResidue().getResidueType());
        sb.append(estimateEntity.getResidue().getResidueMensure());
        try {
            mailFactory.sendMessage(sb.toString());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

}

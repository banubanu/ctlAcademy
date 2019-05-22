package com.prodapt.ctlacademy.service;


	import java.util.List;

    import com.prodapt.ctlacademy.model.ElNomination;


    public interface ElNomiService {
           
                  List<ElNomination> getAll();
                  ElNomination save(ElNomination  en);
           }


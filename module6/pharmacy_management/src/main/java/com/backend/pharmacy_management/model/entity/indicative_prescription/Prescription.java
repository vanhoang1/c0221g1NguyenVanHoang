package com.backend.pharmacy_management.model.entity.indicative_prescription;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;  // id đơn thuốc
    private String prescriptionCode;  // mã code
    private String prescriptionName;   // tên đơn thuốc
    private String symptom;    // triệu chứng
    private String object;     // đối tượng uống thuốc
    private int numberOfDay;  // số ngày uống
    private  String note;  //  ghi chú
    @JsonBackReference
    @OneToMany(targetEntity = PrescriptionIndicative.class)
    private List<PrescriptionIndicative> prescriptionIndicatives;
}

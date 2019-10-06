package com.mmihaylov.model.db;

import com.mmihaylov.model.enums.TaskStatus;
import com.mmihaylov.model.util.CustomAuditListener;

import javax.persistence.*;

@Entity
@Table(name = "IMPORT_CAR_TASK")
@EntityListeners({CustomAuditListener.class})
public class ImportCarTask extends BaseDbEntity implements DbEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SOURCE")
    private String source;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private TaskStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID")
    private Car car;

    @Column(name = "ERROR")
    private String error;

    public ImportCarTask() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

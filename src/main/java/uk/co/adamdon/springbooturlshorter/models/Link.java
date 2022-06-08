package uk.co.adamdon.springbooturlshorter.models;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "links", schema = "PUBLIC")
public class Link
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    private Date createdAt;

    @NotNull
    @NotBlank(message = "url is mandatory")
    @Column(name = "url")
    private String url;

    @Column(name = "code")
    private String code;


    public Link()
    {

    }


    @Override
    public String toString()
    {
        return "Link{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", url='" + url + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    //
    ////Getters and Setters
    //
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }
}

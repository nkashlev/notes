package ru.nkashlev.notes.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.nkashlev.notes.model.StyleText;

import javax.persistence.*;
@Data
@Entity
@Table(name = "Note")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long noteId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Type(type = "jsonb")
    @Column(name = "style_text")
    private StyleText styleText;
}

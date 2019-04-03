import React, { Component } from "react";
import Note from "./note";
import { Grid } from "@material-ui/core";

export default class Notes extends Component {
  render() {
    const { notes, deleteNote, updateNote, filteredKeyword } = this.props;
    return (
      <Grid container spacing={24}>
        <Grid item xs={12} className="note-header">
          <h2>Here are all of your current notes</h2>
        </Grid>
        {notes.length === 0 ? (
          <p className="no-notes">
            Oops! There are no notes! Click new note to get started
          </p>
        ) : (
          notes.map(note => (
            <Grid item xs={3}>
              <Note
                key={note.id}
                note={note}
                deleteNote={deleteNote}
                updateNote={updateNote}
              />
            </Grid>
          ))
        )}
      </Grid>
    );
  }
}

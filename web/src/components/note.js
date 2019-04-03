import React, { Component } from "react";

import {
  Card,
  IconButton,
  CardHeader,
  TextField,
  Button
} from "@material-ui/core";
import { Delete, Edit } from "@material-ui/icons";

export default class Note extends Component {
  state = {
    isEditMode: false,
    editValue: ""
  };

  componentDidMount() {
    const { note } = this.props;
    const { editValue } = this.state;
    //update state with body to providde a default value
    if (editValue !== note.body) {
      this.setState({
        editValue: note.body
      });
    }
  }
  editText = () => {
    this.changeEditMode(true);
  };

  closeEditText = () => {
    this.changeEditMode(false);
  };

  saveAndCloseEditText = (updateNote, oldNote, editValue) => {
    this.changeEditMode(false);
    //make a copy of the old note to update with new value
    let newNote = oldNote;
    newNote.body = editValue;

    updateNote(newNote);
  };

  changeEditMode = bool => this.setState({ isEditMode: bool });

  handleEditChange = e => {
    this.setState({
      editValue: e.target.value
    });
  };

  render() {
    const { isEditMode, editValue } = this.state;
    const { note, deleteNote, updateNote } = this.props;

    return (
      <Card>
        {!isEditMode ? (
          <CardHeader
            title={note.body}
            action={
              <React.Fragment>
                <IconButton onClick={() => this.editText(note)}>
                  <Edit />
                </IconButton>
                <IconButton onClick={() => deleteNote(note.id)}>
                  <Delete />
                </IconButton>
              </React.Fragment>
            }
          />
        ) : (
          <React.Fragment>
            <TextField
              id="outlined-bare"
              value={editValue}
              margin="normal"
              variant="outlined"
              fullWidth
              onChange={this.handleEditChange}
            />
            <span className={"update-buttons"}>
              <Button
                variant="contained"
                onClick={this.closeEditText}
                size="small"
              >
                Cancel
              </Button>
            </span>
            <span className={"update-buttons"}>
              <Button
                variant="contained"
                color="primary"
                className={"update-buttons"}
                onClick={() =>
                  this.saveAndCloseEditText(updateNote, note, editValue)
                }
                size="small"
              >
                Update
              </Button>
            </span>
          </React.Fragment>
        )}
      </Card>
    );
  }
}

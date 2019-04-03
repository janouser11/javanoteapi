import React, { Component } from "react";
import { withStyles } from "@material-ui/core/styles";
import {
  Input,
  Button,
  Card,
  Typography,
  CardHeader,
  TextField
} from "@material-ui/core";

function getModalStyle() {
  const top = 50;
  const left = 50;

  return {
    top: `${top}%`,
    margin: "auto",
    left: `${left}%`,
    transform: `translate(-${top}%, -${left}%)`
  };
}

const styles = theme => ({
  paper: {
    position: "absolute",
    width: theme.spacing.unit * 50,
    backgroundColor: theme.palette.background.paper,
    boxShadow: theme.shadows[5],
    padding: theme.spacing.unit * 4
  },
  textField: {
    marginLeft: theme.spacing.unit,
    marginRight: theme.spacing.unit,
    width: theme.spacing.unit * 50
  },
  button: {
    margin: theme.spacing.unit
  },
  cardHeader: {
    margin: theme.spacing.unit
  }
});

class ModalContent extends Component {
  state = {
    newNoteValue: ""
  };

  onMultilineChange = e => {
    this.setState({
      newNoteValue: e.target.value
    });
  };
  render() {
    const { newNoteValue } = this.state;
    const { classes, handleClose, handleSave } = this.props;
    return (
      <Card className={classes.paper} elevation={1} style={getModalStyle()}>
        <h2 className={classes.cardHeader}>New Note</h2>
        <TextField
          id="outlined-multiline-flexible"
          label="Write down your thoughts"
          multiline
          rowsMax="4"
          value={newNoteValue}
          onChange={this.onMultilineChange}
          className={classes.textField}
          margin="normal"
          variant="outlined"
        />
        <div>
          <Button
            variant="contained"
            className={classes.button}
            onClick={handleClose}
          >
            Cancel
          </Button>
          <Button
            variant="contained"
            color="primary"
            className={classes.button}
            onClick={() => handleSave(newNoteValue)}
          >
            Save
          </Button>
        </div>
      </Card>
    );
  }
}

// We need an intermediary variable for handling the recursive nesting.
const SimpleModalWrapped = withStyles(styles)(ModalContent);

export default SimpleModalWrapped;

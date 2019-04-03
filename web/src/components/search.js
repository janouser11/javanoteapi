import React, { Component } from "react";
import SearchIcon from "@material-ui/icons/Search";
import { fade } from "@material-ui/core/styles/colorManipulator";
import { TextField, InputBase, Input, InputAdornment } from "@material-ui/core";

export default class Search extends Component {
  render() {
    return (
      <TextField
        fullWidth
        placeholder={"Search"}
        variant="outlined"
        onChange={e => this.props.filterNotesBySearchResult(e.target.value)}
        InputProps={{
          startAdornment: (
            <InputAdornment position="start">
              <SearchIcon />
            </InputAdornment>
          )
        }}
      />
    );
  }
}

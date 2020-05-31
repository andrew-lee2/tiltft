import {WiredCombo, WiredItem} from "react-wired-elements";
import Col from "react-bootstrap/Col";
import './styles.scss';
import React from "react";

export default function RegionSelect(props) {
  const regionNames = ["NA1", "BR1", "EUN1", "EUW1", "JP1", "KR", "LA1", "LA2", "OC1", "RU", "TR1"];
  const regionItems = regionNames.map(function(region){
    return (
      <WiredItem value={region}>
        {region}
      </WiredItem>
    )
  });

  return (
    <WiredCombo
      className={"region-select"}
      popupBgColor="white"
      selectedBgColor="gray"
      onSelect={props.onSelect}
      value={props.value}
    >
      {regionItems}
    </WiredCombo>
  );
}
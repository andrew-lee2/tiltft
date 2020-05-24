import React, { useState, useEffect } from 'react';
import {WiredButton, WiredItem, WiredCombo, WiredInput, WiredSpinner} from "react-wired-elements";
import './styles.scss';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'

function LoadingSpinner(props) {
  if (props.isLoading) {
    return (
        <WiredSpinner
          duration={1400}
          spinning
        />
      );
  } else {
    return null;
  }
}

function ResultsDisplay(props) {
  if (props.isLoaded) {
    return (
      // TODO need to make a mapping of rating to text to display
      <div>
        asdasdasdasdassasd
      </div>
    )
  } else {
    return null;
  }
}

// TODO call api
// async function fetchRating() {
//   await sleep(300);
// }
const sleep = (milliseconds) => {
  return new Promise(resolve => setTimeout(resolve, milliseconds))
}


function Home() {
  const [summonerName, setSummonerName] = useState('');
  const [region, setRegion] = useState('');
  const [loading, setLoading] = useState(false);
  const [loaded, setLoaded] = useState(false);

  const handleSummonerName = event => {
    setSummonerName(event.target.value);
  };

  const handleRegion = event => {
    setRegion(event.target.value);
  };

  const handleSubmit = event => {
    if (region !== '' && summonerName !== '') {
      setLoading(true);
      // TODO fire off fetch
      sleep(3000).then(() => {
        setLoading(false);
        // TODO if never loads have some kind of error?
        setLoaded(true);
      });
      // fetchRating();

    }
  };

  return (
    // TODO center this
    <Container>
      <Col>
        <h2>
          Are you tilted?
        </h2>
        <Row>
          {/*// TODO make this wider*/}
          <Col>
            <WiredInput
              placeholder="Enter a summoner name"
              onChange={handleSummonerName}
              value={summonerName}
            />

          </Col>
          <Col>
            {/*TODO split this out*/}
            <WiredCombo
              popupBgColor="white"
              selectedBgColor="gray"
              onSelect={handleRegion}
              value={region}
            >
              <WiredItem value="NA1">
                NA1
              </WiredItem>
              <WiredItem value="BR1">
                BR1
              </WiredItem>
              <WiredItem value="EUN1">
                EUN1
              </WiredItem>
              <WiredItem value="EUW1">
                EUW1
              </WiredItem>
              <WiredItem value="JP1">
                JP1
              </WiredItem>
              <WiredItem value="KR">
                KR
              </WiredItem>
              <WiredItem value="LA1">
                LA1
              </WiredItem>
              <WiredItem value="LA2">
                LA2
              </WiredItem>
              <WiredItem value="OC1">
                OC1
              </WiredItem>
              <WiredItem value="RU">
                RU
              </WiredItem>
              <WiredItem value="TR1">
                TR1
              </WiredItem>
            </WiredCombo>
          </Col>
          <Col>
            <WiredButton
              onClick={handleSubmit}
            >
              Submit
            </WiredButton>
          </Col>

        </Row>
      </Col>

      <LoadingSpinner
        isLoading={loading}
      />

      <ResultsDisplay isLoaded={loaded}/>

    </Container>

  );
}

export default Home;
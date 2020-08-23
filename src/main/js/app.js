import 'bootstrap/dist/css/bootstrap.css';
import React from 'react';
import {Provider} from 'react-redux';
import {applyMiddleware, createStore} from 'redux';
import ReactDOM from 'react-dom';
import reducer from './store/reducer';
import {fetchJobs} from './services/jobs';
import {actions} from './store/action-creator';
import 'regenerator-runtime/runtime';
import {setupMockData} from './util/setupMockData';
import {HomeConnector} from './connectors/home-connector';
import {fetchJobRequest} from './services/job-request';
import {fetchCandidates} from './services/candidate';
import thunk from 'redux-thunk';

const init = async () => {
    const store = createStore(reducer, {}, applyMiddleware(thunk));
    setupMockData();
    const jobs = await fetchJobs();
    const jobRequests = await fetchJobRequest();
    const candidates = await fetchCandidates();
    store.dispatch(actions.setJobs(jobs));
    store.dispatch(actions.setJobRequests(jobRequests));
    store.dispatch(actions.setCandidates(candidates));
    ReactDOM.render(
        <Provider store={store}>
            <HomeConnector/>
        </Provider>,
        document.getElementById('root')
    );
};

init();




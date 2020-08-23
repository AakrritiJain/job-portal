import {connect} from 'react-redux';
import {actions} from '../store/action-creator'
import Home from '../components/Home';

const mapStateToProps = (state) => {
    return {
        role: state.role
    }
};

const mapDispatchToProps = {
    setUser: actions.setUser,
    setSelectedJob: actions.setSelectedJob
};

export const HomeConnector = connect(mapStateToProps, mapDispatchToProps)(Home);
